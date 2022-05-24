package com.example.stringreducto.domain.use_case

class VerifyInput {
    operator fun invoke(input: String): Boolean {
        input.forEach { letter ->
            if(letter != 'a' && letter != 'b' && letter != 'c') return false
        }
        return true
    }
}