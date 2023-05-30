package com.capstone.arahku.model

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun saveToken(token: String){
        dataStore.edit { preference ->
            preference[TOKEN_KEY] = token
        }
    }

    suspend fun isLogin(){
        dataStore.edit { preference ->
            preference[STATE_KEY] = true
        }
    }

    suspend fun logout(){
        dataStore.edit { preference ->
            preference[STATE_KEY] = false
        }
    }

    fun getState(): Flow<Boolean>{
        return dataStore.data.map { preference ->
            preference[STATE_KEY] ?: false
        }
    }
    fun getToken(): Flow<String> {
        return dataStore.data.map { preference ->
            preference[TOKEN_KEY] ?: ""
        }
    }


    companion object {
        @Volatile
        private var INSTANCE:UserPreference? = null

        private val TOKEN_KEY = stringPreferencesKey("token")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}