package com.tasklist.listview

import android.content.Context
import android.util.ArraySet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListPeopleAdapter(var context: Context, var employees: List<Employee>) : BaseAdapter() {

    private val TAG: String = "ListPeopleAdapter"

    //Creating this variable for understanding
    private var viewsCount: ArraySet<View?> = ArraySet()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val viewHolder: ListPeopleViewHolder

        //here convertView is providing view which goes out of the screen.
        var view: View? = convertView

        if (view == null) {
            //This class will inflate the person.xml file in the view we got as a parameter in getView() method
            val inflator: LayoutInflater = LayoutInflater.from(context)
            view = inflator.inflate(R.layout.person, parent, false)
            viewHolder = ListPeopleViewHolder()
            viewHolder.personName = view.findViewById(R.id.tv_person_name)
            viewHolder.personDesignation = view.findViewById(R.id.tv_person_designation)
            viewHolder.personCompany = view.findViewById(R.id.tv_person_company)

            //each new view will be associated to its own viewHolder so that when recycle view return
            //we get its viewHolder with which reduce the findViewById call since its a expensive operation.
            view.tag = viewHolder
        } else {

            //When view return we get its viewHolder which we had set when its newly created.
            viewHolder = view.tag as ListPeopleViewHolder
        }

        viewHolder.personName?.text = employees[position].name
        viewHolder.personDesignation?.text = employees[position].designation
        viewHolder.personCompany?.text = employees[position].companyName

        //To check whether new views are creating or not
        viewsCount.add(view)

        Log.i(TAG, "$view call ${viewsCount.size}")
        return view
    }

    override fun getItem(position: Int): Any {
        Log.i(TAG, "getItem() method called")
        return employees[position]
    }

    override fun getItemId(position: Int): Long {
        Log.i(TAG, "getItemId() method called")
        return position.toLong()
    }

    override fun getCount(): Int {
        Log.i(TAG, "getCount() method called")
        return employees.size
    }

    private class ListPeopleViewHolder {
        var personName: TextView? = null
        var personDesignation: TextView? = null
        var personCompany: TextView? = null

    }

}