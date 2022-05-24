# String-Reducto

 - Aplicação em Kotlin, utilizando MVVM, Compose e Dagger Hilt.
 
 - A função do projeto consiste em receber uma string contendo variações dos caracteres 'a', 'b' e 'c' e reduzí-la conforme as regras:
 
   Caracteres iguais que sejam adjacentes devem ser mantidos. Caso hajam pares de caracteres diferentes alinhados adjacentemente, 
   substituir o par pelo caractere restante. Reduzir a string até não ser mais possível, e então exibir o resultado final
   O programa deve ser capaz de receber diferentes inputs de string, checar se o input é válido e então realizar o processo.
   
   Exemplos: abc -> cc
             bbca -> baa -> ca -> b
             aabc -> acc -> bc -> a
  
 - Executável em Android Studio, simplesmente rodando "app" na IDE por um emulador ou por um dispositivo android.
