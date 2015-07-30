package com.example.retrofittest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.retrofittest.Model.User;
import com.example.retrofittest.R;

import java.util.List;

/**
 * Created by cloud on 22/7/15.
 */
public class Customlistadapter extends BaseAdapter {

    Context context;
    List<User> users;
      private static LayoutInflater inflater=null;
    public Customlistadapter(Context con, List<User> userList) {
        // TODO Auto-generated constructor stub
       users = userList;
        context=con;
//        this.inflater = ( LayoutInflater )context.
//                 getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.inflater = LayoutInflater.from(context);
    }
    public class ViewHolder
    {
        TextView name;
        TextView number;
    }
    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          if (convertView == null){
              // TODO Auto-generated method stub
              ViewHolder holder=new ViewHolder();
              convertView = inflater.inflate(R.layout.unit, null);
              holder.name=(TextView) convertView.findViewById(R.id.textView1);
              holder.number=(TextView) convertView.findViewById(R.id.textView2);
              holder.name.setText(users.get(position).getFirstName().toString());
              if (users.get(position).getPhone().equals(null)){
                  holder.number.setText(users.get(position).getPhones().get(0).getCountryCode() + users.get(position).getPhones().get(0).getNumber());
              } else {
                  holder.number.setText(users.get(position).getPhone().toString());
              }
          }


        return convertView;
    }

    /*Context context;

 protected List<Car> listCars;
 LayoutInflater inflater;

 public ListCarsAdapter(Context context, List<Car> listCars) {
 this.listCars = listCars;
 this.inflater = LayoutInflater.from(context);
 this.context = context;
 }

 public int getCount() {
 return listCars.size();
 }

 public Car getItem(int position) {
 return listCars.get(position);
 }

 public long getItemId(int position) {
 return listCars.get(position).getDrawableId();
 }

 public View getView(int position, View convertView, ViewGroup parent) {
 ViewHolder holder;
 if (convertView == null) {

 holder = new ViewHolder();
 convertView = this.inflater.inflate(R.layout.layout_list_item,
 parent, false);

 holder.txtModel = (TextView) convertView
 .findViewById(R.id.txt_car_model);
 holder.txtColor = (TextView) convertView
 .findViewById(R.id.txt_car_color);
 holder.txtPrice = (TextView) convertView
 .findViewById(R.id.txt_car_price);
 holder.imgCar = (ImageView) convertView.findViewById(R.id.img_car);

 convertView.setTag(holder);
 } else {
 holder = (ViewHolder) convertView.getTag();
 }

 Car car = listCars.get(position);
 holder.txtModel.setText(car.getModel());
 holder.txtColor.setText(car.getColor());
 holder.txtPrice.setText(car.getPrice() + " €");
 holder.imgCar.setImageResource(car.getDrawableId());

 return convertView;
 }

 private class ViewHolder {
 TextView txtModel;
 TextView txtColor;
 TextView txtPrice;
 ImageView imgCar;
 }*/
}
