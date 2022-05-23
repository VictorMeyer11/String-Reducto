package com.example.stringreducto.domain.use_case

class VerifyInput {
    operator fun invoke(input: String): Boolean {
        if(input.matches("[abc]".toRegex())) return true
        return false
    }
}