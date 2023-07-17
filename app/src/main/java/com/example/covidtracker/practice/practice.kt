package com.example.covidtracker.practice

 class practice {
    var str ="Hello"
    class prac{
       val s1="Mophat"
       fun getWord (str2:String): String{
           var s2 = s1.plus(str2)
           return s2
       }
   }
}

fun main(){
     val nested = practice.prac()
    var result = nested.getWord("successful call")
    print(result)
  }