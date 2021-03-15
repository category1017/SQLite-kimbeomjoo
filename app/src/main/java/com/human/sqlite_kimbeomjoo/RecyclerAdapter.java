package com.human.sqlite_kimbeomjoo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * recyclerAdapter클래스는 recyclerView Component와 SQLiteDB를 바인딩 시키는 기능.
 * 필수 클래스 2개 Adapter,ViewHolder 필요
 * 중첩클래스를 만드는 방법 : RecyclerAdapter, ItemViewHolder
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    //안드로이드에서 제공되는 OnItemClick 리스너는 매개변수 4개이기 때문에 2개짜리로 추가
    public interface OnItemClickListener {//중첩클래스 내에서 사용
        void onItemClick(View v, int position);//매개변수 2개인 메서드 명세 생성
    }
    //멤버변수
    public OnItemClickListener mOnItemClickListener;
    private List mList;

    //인터페이스 OnClickListener에 대한 SET메서드 생성(나중에 메인액티비티에서 사용예정, 아래)
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
    //ItemViewHolder클래스가 호출되면 자동으로 아래onCreateViewHolder메서드가 실행됨.
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //레이아웃 xml을 자바단에서 로딩할때 inflater메서드 사용(아래) =>startActivity(화면을 띄울때)비슷, 화면을 띄우진않음, 메모리에 올림
        //inflate()매개변수로 xml 디자인이 필수. RecyclerView 내에 들어가는 아이템디자인 생성->recyclerview_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new ItemViewHolder(view);
    }
    //생성자 메서드 : 메인액티비티java에서 호출하면서 매개변수 리스트쿼리값을 보냅니다.
    public RecyclerAdapter(List itemList){
        mList = itemList;//현재 클래스에서 최초로 실행
    }
    //아래 onBindViewHolder에서 mList값을 사용하려면, mList값을 생성해야한다(위)
    //뷰홀더와 포지션pos를 이용해서 xml디자인TextView item에 기존값 출력하기
    //개발자가 호출하는 것이 아니고, 안드로이드이 레이아웃 관리자프로그램이 자동으로 호출
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        //구현은 개발자가 코딩(아래)
        StudentVO studentVO = (StudentVO) mList.get(position);//1개 레코드 저장
        //리사이클러뷰의 recyclerview_item.xml디자인에 데이터를 출력(아래)
        holder.itemGrade.setText(Integer.toString(studentVO.getmGrade()));
        holder.itemNumber.setText(Integer.toString(studentVO.getmNumber()));
        holder.itemName.setText(studentVO.getmName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //중첩클래스 생성(RecyclerView컴포넌트에 데이터를 홀딩시키는 클래스)
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        //멤버변수선언:클래스 전역변수
        private TextView itemGrade;//홀더내에 객체 중 학년 아이템
        private TextView itemNumber;//홀더내 객체 중 학번 아이템
        private TextView itemName;//홀더내 객체 중 학생이름 아이템
        public ItemViewHolder(@NonNull View itemView) {//new 생성자 메서드
            super(itemView);//메모리에 ViewHolder클래스를 로딩하게 됨.
            //변수 객체로 만듦.(메모리에 로딩 실행가능하게 변경)
            itemGrade = itemView.findViewById(R.id.item_grade);//xml의 컴포넌트를 객체화 시킴
            itemNumber = itemView.findViewById(R.id.item_number);
            itemName = itemView.findViewById(R.id.item_name);
            //new키워드로 생성될때(객체가 만들어질때) 아이템클릭 이벤트 생성.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int pos = getAdapterPosition();//리사이클러뷰 클릭한 리스트 위치
                    System.out.println("디버그 itemView.setOnClickListener : "+ pos);
                    if(pos != RecyclerView.NO_POSITION){//손가락으로 클릭했을때
                        //선택한 학생이 있을때 실행
                        if(mOnItemClickListener !=null){
                            mOnItemClickListener.onItemClick(v,pos);
                        }
                    }
                }
            });
            //작동확인 후 나중에 람다식(자바버전8이후부터 지원가능)으로 변경예정
        }
    }
}
