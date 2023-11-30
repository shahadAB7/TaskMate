package net.penguincoders.doit;

import ...

 public class MainActivity extends AppCompatActivity { 
  
  private RecyclerView tasksRecyclerView;
  private ToDoAdapter taskAdapter;

  private List<ToDoModel> taskList;

  
  @Override 
protected void onCreate (Bundle savedInstanceState) { 
  super.onCreate(savedInstanceState); 
  setContentView(R.layout.activity main);
  getSupportActionBar().hide();

taskList=new ArrayList<>();
  
  tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
  tasksRecyclerView.setLayoutManager(new LinearLayoutManager( context: this));
  tasksAdapter = new ToDoAdapter( activity: this);
  tasksRecyclerView.setAdapter(tasksAdapter);
  
  ToDoModel task = new ToDoModel();
  task.setTask("This is a Test Task");
  task.setStatus(0);
  task.setId(1);
  
  taskList.add(task);
  taskList.add(task);
  taskList.add(task);
  taskList.add(task);
  taskList.add(task);
  
  tasksAdapter.setTasks(taskList);
}
}
