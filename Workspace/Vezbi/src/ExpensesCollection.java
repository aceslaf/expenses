import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.DateFormatter;


public class ExpensesCollection {
	
	private Map<Date,DailyExpense> allExpenses;
	
	public ExpensesCollection() {
		super();
		this.allExpenses=new HashMap<Date, DailyExpense>();
	}
	
	public static ExpensesCollection parseFromFie(String filePath)
	{

        // This will reference one line at a time
        String line = null;
        SimpleDateFormat  dateFormater = new SimpleDateFormat ("d.M.yyyy");
        ExpensesCollection expensesCollection=new ExpensesCollection();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(filePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            StringBuffer buffer = new StringBuffer();
            boolean date1=false;
            boolean date2=false;
            while((line = bufferedReader.readLine()) != null) {
            	if("".equals(line.trim()))
            	{
            		continue;
            	}
                buffer.append(line.trim());
                buffer.append("\n");
                if(line.startsWith("#"))
                {
                	if(!date1)
                	{
                		date1=true;
                	}else
                	{
                		date2=true;
                	}
                }
                
                if(date1 && date2)
                {
                	expensesCollection.AddDailyExpense(DailyExpense.parse(buffer.toString(), "d.M.yyyy"));
                	date1=false;
                    date2=false;
                    buffer=new StringBuffer();
                }
                
            }    

            // Always close files.
            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                		filePath + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filePath + "'");                   
            // Or we could just do this: 
            // ex.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return expensesCollection;
    }

	private void AddDailyExpense(DailyExpense newExpense)
	{
		DailyExpense existing =this.allExpenses.containsKey(newExpense.getDate())?this.allExpenses.get(newExpense.getDate()):null;
		DailyExpense combinedExpense;
		if(existing!=null)
		{
			if(!newExpense.getDate().equals(existing.getDate()))
			{
				throw new NullPointerException();
			}
			combinedExpense=newExpense.combine(existing);
		}else
		{
			combinedExpense=newExpense;
		}
		this.allExpenses.put(combinedExpense.getDate(), combinedExpense);
	}
	
	public DailyExpense getExpenseForDate(Date date)
	{		
		return this.allExpenses.get(date);
	}
	
	public List<DailyExpense> getAllExpenses()
	{
		return new ArrayList<DailyExpense>(this.allExpenses.values());
	}
}
