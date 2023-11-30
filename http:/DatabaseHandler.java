package net.penguincoders.doit.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLite0penHelper;

import net.penguincoders.doit.Model.ToDoModel:
  
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
  
  private static final int VERSION = 1;
  private static final String NAME ="toDoListDatabase";
  private static final String TODO TABLE="todo";
  private static final String ID = "id";
  private static final String TASK ="task";
  private static final String STATUS = "status";
  private static final CREATE TODO TABLE = "CREATE TABLE+ TODO TABLE + "(" + ID+ INTEGER PRIMARY KEY AUTOINCREMENT, "
                                      +TASK +" TEXT," + STATUS + "INTEGER)";
private SQLiteDatabase db;

private DatabaseHandler (Context context) {
  super(context, NAME, Factory: null, VERSION);
}

@Override
  public void onCreate(SQLiteDatabase db) {
  db.execSQL(CREATE_TODO_TABLE);
}

@Override
  public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
  //Drop the older tables 
  db.execSOL("DROP TABLE IF EXISTS + TODO_TABLE);
  //Create tabes again 
  onCreate(db);
}
  public void openDatabase() {
  db = this.getWritableDatabase();
  }

public void insertTask(ToDoModel task) {
  ContentValues cv = new ContentValues(); cv.put(TASK, task.getTask());
cv.put(STATUS, 0);
db.insert(TODO_TABLE, nullColumnHack: null, cv);
}

public List<ToDoModel> getAllTasks() {
  List<ToDoModel> taskList = new ArrayList<>();
  Cursor cur null;
  db.beginTransaction();
  tryt cur db.query(TODO_TABLE, columns: null, selection: null, selectionArgs: null, groupBy:null, having:null, orderBy:null, limit:null);
      if(cur != null) { 
    if(cur.moveToFirst()) { 
      do{
        ToDoModel task = new ToDoModel();
        task.setId(cur.getInt (cur.getColumnIndex(ID)));
        task.setTask(cur.getString (cur.getColumnIndex(TASK)));
        task.setStatus(cur.getInt (cur.getColumnIndex(STATUS)));
        taskList.add(task);
      } while(cur.moveToNext());
    }
      }
}
finally {
  db.endTransaction();
  cur.close();
}
  return taskList;

}
public void updateStatus(int id, int status) {
  ContentValues cv = new ContentValues();
  cv.put(STATUS, status);
  db.update(TODO_TABLE, CV, whereClause: ID + "=?", new String[] {String.valueOf(id)});
}

public void updateTask(int id, String task) {
    ContentValues cv = new ContentValues();
  cv.put (TASK, task);
  db.update(TODO_TABLE, cv, whereClause: ID + "=?", new String[] {String.valueOf(id)});
}

public void deleteTask(int id) {
    ContentValues cv = new ContentValues(){
  db.delete(TODO_TABLE, cv, whereClause: ID + "=?", new String[] {String.valueOf(id)});
}
  }
