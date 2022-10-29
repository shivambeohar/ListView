package com.tasklist.listview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasklist.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Reference to the RecyclerView Object in order to set the recyclerView adapter.
        mRecyclerView = binding.recyclerView

        //Data of the employees
        val employees: List<Employee> = listOf(Employee(name="Ravi",designation = "Software Engineer",companyName = "Globallogic"),
            Employee(name = "Dinesh",designation = "Senior Test Engineer",companyName = "Globallogic"),
            Employee(name = "Ramesh",designation = "QA Analyst",companyName = "Globallogic"),
            Employee(name = "Suresh",designation = "Business Analyst",companyName = "Globallogic"),
            Employee(name = "Mohan",designation = "Test Engineer",companyName = "Globallogic"),
            Employee(name = "Sohan",designation = "Associate Software Engineer",companyName = "Globallogic"),
            Employee(name = "Kamlesh",designation = "Software Engineer",companyName = "Globallogic"),
            Employee(name = "Dev",designation = "Front End Developer",companyName = "Globallogic"),
            Employee(name = "Sonu",designation = "Back End Developer",companyName = "SpaceX"),
            Employee(name = "Deepesh",designation = "Architect",companyName = "Tesla"),
            Employee(name = "Shubhi",designation = "UX/UI Designer",companyName = "HDFC"),
            Employee(name = "Siddhi",designation = "DBA",companyName = "TCS"),
            Employee(name = "Shivam",designation = "System Engineer",companyName = "JPMorgan"),
            Employee(name = "Varis",designation = "iOS Developer",companyName = "Accenture"),
            Employee(name = "Vikram",designation = "Full Stack Developer",companyName = "Microsoft"),
            Employee(name = "Ayush",designation = "Network Engineer",companyName = "Google"))

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter =
            EmployeeRecyclerViewAdapter(employees = employees) { name, position ->
                Toast.makeText(this, "$name, $position", Toast.LENGTH_SHORT).show()
            }
    }
}
