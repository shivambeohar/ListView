package com.tasklist.listview

import android.content.Context
import android.util.ArraySet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListPeopleAdapter (var context: Context, var employees: List<Employee>) : BaseAdapter(){

    private val TAG: String = "ListPeopleAdapter"

    //Creating this variable for understanding
    private var viewsCount: ArraySet<View?> = ArraySet()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        //here convertView is providing view which goes out of the screen.
        var view: View? = convertView

        if(view == null){
            //This class will inflate the person.xml file in the view we got as a parameter in getView() method
            val inflator: LayoutInflater = LayoutInflater.from(context)
            view = inflator.inflate(R.layout.person,parent,false)
        }

        view?.findViewById<TextView>(R.id.tv_person_name)?.text = employees[position].name
        view?.findViewById<TextView>(R.id.tv_person_designation)?.text = employees[position].designation
        view?.findViewById<TextView>(R.id.tv_person_company)?.text = employees[position].companyName

        //To check whether new views are creating or not
        viewsCount.add(view)

        Log.i(TAG,"$view call ${viewsCount.size}")
        return view
    }

    override fun getItem(position: Int): Any {
        Log.i(TAG,"getItem() method called")
        return employees[position]
    }

    override fun getItemId(position: Int): Long {
        Log.i(TAG,"getItemId() method called")
        return position.toLong()
    }

    override fun getCount(): Int {
        Log.i(TAG,"getCount() method called")
        return employees.size
    }

}