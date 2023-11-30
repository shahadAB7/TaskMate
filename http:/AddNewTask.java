package net.penguincoders.doit; 

import... 

public class AddNewTask extends BottomSheetDialogFragment { 

  public static final String TAG = "ActionBottomDialog"; 

private EditText newTaskText; 
private Button newTaskSaveButton; 
private DatabaseHandler db; 

 public static AddNewTask newInstance(){ 
     return new AddNewTask();
}
}

@Override
public void onCreate (Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
setStyle(STYLE_NORMAL, R.style.DialogStyle); 
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){ 
  View view = inflater.inflate(R.layout.new task, container, attachToRoot false);
  getDialog().getWindow().setSoftInputMode (WindowManager.LayoutParams.SOFT INPUT ADJUST RESIZE);
  return view;
}
  
  @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
    newTaskText = getView().findViewById(R.id.newTaskText);
    newTaskSaveButton = getView().findViewById(R.id.newTaskButton);
  }
}
db = new DatabaseHandler(getActivity());
db.openDatabase();

boolean isUpdate = false;
final Bundle bundle = getArguments();
if (bundle != null){
  isUpdate true;
  String task = bundle.getString( key: "task");
  newTaskText.setText(task);
  if(task.length()>0)
    newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(),R.color.colorPrimaryDark));
}
newTaskText.addTextChangedListener(new TextWatcher() {
  @Override
  public void beforeTextChanged (CharSequence s, int start, int count, int after) {
  }
  
  @Override
  public void onTextChanged (CharSequence s, int start, int before, int count) { 
    if(s.toString().equals("")){ 
      newTaskSaveButton.setEnabled(false); 
      newTaskSaveButton.setTextColor(Color.GRAY);
    }
      elsel{
        newTaskSaveButton.setTextEnabled(true);
        newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(),R.color.colorPrimaryDark));
        }
  
  @Override
  public void afterTextChanged (Editable s) {
}
});

newTaskSaveButton.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) { 
    String text = newTaskText.getText().toString();
    if(finalIsUpdate){ 
        db.updateTask(bundle.getInt( key: "id"), text); 
    }
    else{
      ToDoModel task = new ToDoModel();
      task.setTask(text);
      task.setStatus(0);
    }
    dismiss();
  }
});
}

@Override
  public void onDismiss(DialogInterface dialog){ 
  Activity activity = getActivity();
if(activity instanceof DialogCloseListener){ 
  ((DialogCloseListener)activity).handleDialogClose(dialog);
}
}
}
