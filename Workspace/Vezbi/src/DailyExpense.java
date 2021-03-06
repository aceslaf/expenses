import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DailyExpense {
	private Date date;
	private String description;
	private float cost;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public static DailyExpense parse(String str,String dateFormatStr) throws ParseException
	{
		System.out.println(str);
		SimpleDateFormat dateFormat=new SimpleDateFormat(dateFormatStr);
		String[] lines=str.split("\n");
		if(!lines[0].startsWith("#")||!lines[lines.length-1].startsWith("#"))
		{
			throw new NullPointerException("no lines starting with #");
		}
		Date date1=dateFormat.parse(lines[0].substring(1));
		Date date2=dateFormat.parse(lines[lines.length-1].substring(1));
		if(!date1.equals(date2))
		{
			throw new NullPointerException();
		}
		int sum =0;
		StringBuffer strBuilder=new StringBuffer();
		for (int i = 1; i < lines.length-1; i++) {
			String currentLine=lines[i];
			if(currentLine.startsWith("+"))
			{
				sum+=Integer.parseInt(currentLine.substring(1));
			}else
			{
				strBuilder.append(currentLine+"\n");
			}
		}
		
		return new DailyExpense(date1, strBuilder.toString(), sum);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DailyExpense combine(DailyExpense existing) {
		// TODO Auto-generreturn null;
		if(!existing.getDate().equals(this.getDate()))
		{
			throw new NullPointerException("Dates are not the same");
		}
		
		DailyExpense result= new DailyExpense(this.date,this.description+existing.getDescription(), this.cost+existing.getCost());
		return result;
	}
	public DailyExpense(Date date, String description, float cost) {
		super();
		this.date = date;
		this.description = description;
		this.cost = cost;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf= new SimpleDateFormat("d.M.yyyy");
		return "[date=" + sdf.format(date) + "]\n[ cost=" + cost + "]"+ "\ndescription=\n" + description
				+"\n\n";
	}
	
	
}
