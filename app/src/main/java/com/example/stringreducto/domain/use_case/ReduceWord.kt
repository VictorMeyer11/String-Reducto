package com.example.stringreducto.domain.use_case

class ReduceWord {
    operator fun invoke(word: String): String {
        val missingLetter: (String) -> Char = { letters ->
            if(!letters.contains('a')) 'a'
            else if(!letters.contains('b')) 'b'
            else 'c'
        }

        var currentWord: String
        var reducedWord = word
        
        do {
            currentWord = reducedWord
            for(i in 0.until(currentWord.length-1)) {
                val currentLetter = currentWord[i]
                val nextLetter = currentWord[i+1]
                val letters = "$currentLetter$nextLetter"
                
                if(currentLetter != nextLetter) {
                    reducedWord = currentWord.replaceFirst(
                        letters, 
                        "${missingLetter(letters)}"
                    )
                    break
                }
            }
        } while(currentWord != reducedWord)
        
        return reducedWord
    }
}