package com.tasklist.listview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeRecyclerViewAdapter(var context: Context, var employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeRecyclerViewAdapter.EmployeeViewHolder>() {

    private val TAG: String = "RecyclerViewAdapter"
    private lateinit var employee: Employee


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.person, parent, false)
        Log.i(TAG, "On createViewHolder called Layout Inflated")
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        Log.i(TAG, "OnBindViewHolder called $holder $position")
        employee = employees[position]

        holder.personName.text = employee.name
        holder.personDesignation.text = employee.designation
        holder.personCompany.text = employee.companyName
    }

    override fun getItemCount(): Int {
        Log.i(TAG, "getItemCount called")
        return employees.size
    }


    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val TAG: String = "RecyclerViewAdapter"

        var personName: TextView = itemView.findViewById(R.id.tv_person_name)
        var personDesignation: TextView = itemView.findViewById(R.id.tv_person_designation)
        var personCompany: TextView = itemView.findViewById(R.id.tv_person_company)
    }
}