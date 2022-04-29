package com.example.advanceduiex

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.advanceduiex.databinding.ItemRecyclerviewBinding

class MyAdapter (val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //항목 갯수를 판단하기 위해서 자동 호출
    override fun getItemCount(): Int{
        return datas.size
    }
    //항목의 뷰를 가지는 Holder 를 준비하기 위해 자동 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    //각 항목을 구성하기 위해서 호출
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding
        //뷰에 데이터 출력
        binding.itemData.text= datas[position]
    }
}

//항목 View를 가지는 역활
class MyViewHolder(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)

class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
    //모든 항목이 출력된후 호출
//    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
//        super.onDrawOver(c, parent, state)
//        //뷰 사이즈 계산
//        val width = parent.width
//        val height = parent.height
//        //이미지 사이즈 계산
//        val dr: Drawable? = ResourcesCompat.getDrawable(context.getResources(), R.drawable.dog, null)
//        val drWidth = dr?.intrinsicWidth
//        val drHeight = dr?.intrinsicHeight
//        //이미지가 그려질 위치 계산
//        val left = width / 2 - drWidth?.div(2) as Int
//        val top = height / 2 - drHeight?.div(2) as Int
//        //이미지 출력
//        c.drawBitmap(
//            BitmapFactory.decodeResource(context.getResources(), R.drawable.dog),
//            left.toFloat(),
//            top.toFloat(),
//            null
//        )
//    }
    //각 항목을 꾸미기 위해서 호출
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State)
    {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1

        if (index % 3 == 0) //left, top, right, bottom
            outRect.set(10, 10, 10, 60)
        else
            outRect.set(10, 10, 10, 0)

        view.setBackgroundColor(Color.parseColor("#28A0FF"))
        ViewCompat.setElevation(view, 20.0f)
    }
}