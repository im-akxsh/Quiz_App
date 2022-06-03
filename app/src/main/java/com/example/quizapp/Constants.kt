package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"



    fun getQuiestions(): ArrayList<Quiestion>{
        val quiestionsList = ArrayList<Quiestion>()

        val que1 = Quiestion(1,"What country does this flag belong to?",
           R.drawable.ic_flag_of_australia,"Brazil","Australia",
            "Russia","New Zealand",2)

        quiestionsList.add(que1)
        //return quiestionsList
        val que2= Quiestion(2,"What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,"Argentina",
            "Russia","China","Zimbabwe",1)

        quiestionsList.add(que2)
        //return quiestionsList
        val que3= Quiestion(3,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,"Brazil","Italy",
            "India","Ireland",3)

        quiestionsList.add(que3)
        //return quiestionsList
        val que4 = Quiestion(4,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,"Brazil","France",
            "Belgium","Spain",1)

        quiestionsList.add(que4)
        //return quiestionsList
        val que5 = Quiestion(5,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,"Canada","Bangladesh",
            "Algeria","Denmark",4)

        quiestionsList.add(que5)
        //return quiestionsList
        val que6 = Quiestion(6,"What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,"Argentina","Austria",
            "Albania","Fiji",4)

        quiestionsList.add(que6)
        //return quiestionsList
        val que7 = Quiestion(7,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,"Greece","Germany",
            "Cameroon","Belgium",2)

        quiestionsList.add(que7)
        //return quiestionsList
        val que8 = Quiestion(8,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,"Belgium","Cameroon",
            "Germany","Russia",1)

        quiestionsList.add(que8)
        //return quiestionsList
        val que9 = Quiestion(9,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,"France","Kuwait",
            "Bangladesh","Austria",2)

        quiestionsList.add(que9)
        //return quiestionsList
        val que10= Quiestion(10,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,"Belarus","Australia",
            "Bulgaria","New Zealand",4)

        quiestionsList.add(que10)
        return quiestionsList    }
}