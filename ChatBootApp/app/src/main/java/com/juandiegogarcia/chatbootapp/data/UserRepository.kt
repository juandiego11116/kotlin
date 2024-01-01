package com.juandiegogarcia.chatbootapp.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.tasks.await


class UserRepository(private val auth: FirebaseAuth,
                     private val firestore: FirebaseFirestore) {
    suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): Result<Boolean> =
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
            val user = User(firstName, lastName)
            saveUserToFirestore(user)
            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(e)
        }

    suspend fun login(email: String, password: String): Result<Boolean> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(e)
        }


    private suspend fun saveUserToFirestore(user: User) {
        firestore.collection("users").document(user.email).set(user).await()
    }

    object Injection {
        private val instance: FirebaseFirestore by lazy {
            FirebaseFirestore.getInstance()
        }

        fun instance(): FirebaseFirestore {
            return instance
        }
    }


    suspend fun getCurrentUser(): Result<User> = try {
        val currentUser = auth.currentUser
        val userResult = getUserById(currentUser?.uid ?: "").firstOrNull()

        when (userResult) {
            is Result.Success -> Result.Success(userResult.data ?: User()) // Puedes proporcionar un valor predeterminado si es nulo
            is Result.Error -> Result.Error(userResult.exception)
            null -> Result.Error(Exception("User result is null")) // Agrega un caso para manejar userResult null
        }
    } catch (e: Exception) {
        Result.Error(Exception(e)) // Crear una nueva instancia de Exception
    }

    private fun getUserById(userId: String): Flow<Result<User?>> = callbackFlow {
        val subscription = firestore.collection("users").document(userId)
            .addSnapshotListener { documentSnapshot, _ ->
                documentSnapshot?.let { snapshot ->
                    try {
                        val user = snapshot.toObject(User::class.java)
                        trySend(Result.Success(user))
                    } catch (e: Exception) {
                        // Manejar la excepción y enviarla como un resultado de error
                        trySend(Result.Error(e))
                    }
                }
            }

        awaitClose { subscription.remove() }
    }


}