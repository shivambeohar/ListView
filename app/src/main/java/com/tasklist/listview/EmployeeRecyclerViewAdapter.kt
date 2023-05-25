package com.tasklist.listview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tasklist.listview.databinding.PersonBinding

const val TAG: String = "Recyclerview"

class EmployeeRecyclerViewAdapter(
    val employees: List<Employee>,
    val clickListener: (String, Int) -> (Unit)
) :
    RecyclerView.Adapter<EmployeeRecyclerViewAdapter.EmployeeViewHolder>() {

    private lateinit var employee: Employee

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val personViewBinding: PersonBinding = PersonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        Log.i(TAG, "OnCreateViewHolder called Layout Inflated")
        return EmployeeViewHolder(personViewBinding) { adapterPosition ->
            clickListener(employees[adapterPosition].name, adapterPosition)
        }
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

    class EmployeeViewHolder(personViewBinding: PersonBinding, clickAtPosition: (Int) -> (Unit)) :
        RecyclerView.ViewHolder(personViewBinding.root) {
        val personName: TextView = personViewBinding.tvPersonName
        val personDesignation: TextView = personViewBinding.tvPersonDesignation
        val personCompany: TextView = personViewBinding.tvPersonCompany

        init {
            personViewBinding.root.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }
    }
}