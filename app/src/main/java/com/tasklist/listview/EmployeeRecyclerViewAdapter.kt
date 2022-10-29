package com.tasklist.listview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val TAG: String = "Recyclerview"

class EmployeeRecyclerViewAdapter(val employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeRecyclerViewAdapter.EmployeeViewHolder>() {

    private lateinit var employee: Employee

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.person, parent, false)
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
        Log.i(TAG, "getItemCount called ${employees.size}")
        return employees.size
    }

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView = itemView.findViewById(R.id.tv_person_name)
        val personDesignation: TextView = itemView.findViewById(R.id.tv_person_designation)
        val personCompany: TextView = itemView.findViewById(R.id.tv_person_company)
    }
}