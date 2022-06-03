package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuiestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition: Int=1
    private var mQuiestionsList: ArrayList<Quiestion>?= null
    private var mSelectedOptionPosition: Int=0
    private var mCorrectAnswers : Int = 0

    private var mUserName : String? = null

    private var progressBar: ProgressBar?= null
    private var tvProgress: TextView?= null
    private var tvQuestion: TextView?= null
    private var ivImage: ImageView?= null
    private var tvOptionOne: TextView?= null
    private var tvOptionTwo: TextView?= null
    private var tvOptionThree: TextView?= null
    private var tvOptionFour: TextView?= null
    private var btnSubmit: Button?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_quiestions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_quiestion)
        ivImage=findViewById(R.id.iv_image)
        tvOptionOne=findViewById(R.id.tv_optionOne)
        tvOptionTwo=findViewById(R.id.tv_optionTwo)
        tvOptionThree=findViewById(R.id.tv_optionThree)
        tvOptionFour=findViewById(R.id.tv_optionFour)
        btnSubmit=findViewById(R.id.btn_submit)

        mQuiestionsList = Constants.getQuiestions()

        setQuiestion()


    }

    private fun setQuiestion() {
        defaultOptionsView()

        val quiestion: Quiestion = mQuiestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(quiestion.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = quiestion.quiestion
        tvOptionOne?.text = quiestion.optionOne
        tvOptionTwo?.text = quiestion.optionTwo
        tvOptionThree?.text = quiestion.optionThree
        tvOptionFour?.text = quiestion.optionFour

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        if(mCurrentPosition==mQuiestionsList!!.size)
        {
            btnSubmit?.text="FINISH"
        }else{
            btnSubmit?.text="SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.border_bg
            )

        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_optionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_optionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_optionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_optionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuiestionsList!!.size -> {
                            setQuiestion()
                        }
                        else -> run {
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuiestionsList?.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            startActivity(intent)
                            finish()
                        }

                    }

                }else{
                    val quiestion=mQuiestionsList?.get(mCurrentPosition-1)
                    if(quiestion!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(quiestion.correctAnswer,R.drawable.correct_border_bg)

                    if(mCurrentPosition==mQuiestionsList!!.size){
                        btnSubmit?.text="FINISH"
                    }else
                    {
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }

    }

    private fun answerView(answer:Int,drawableView : Int){
        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }


    }
}
