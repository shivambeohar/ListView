package com.tasklist.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Reference to the ListView Object in order to set the custom adapter.
        listView = findViewById(R.id.list_view)

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

        //Telling the list view to use this custom adapter(create because we have to show person data type on each row)
        // which extends to baseAdapter.
        listView.adapter = ListPeopleAdapter(this,employees)


    }
}
