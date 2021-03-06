import java.util.Comparator;


public class DailyExpenseDateComparator extends AbstractDailyExpenseComparator implements Comparator<DailyExpense>{

	public DailyExpenseDateComparator(boolean isAscending) {
		super(isAscending);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(DailyExpense o1, DailyExpense o2) {
		if(this.isAscending())
		{
			return Long.compare(o1.getDate().getTime(), o2.getDate().getTime());
		}else
		{
			return Long.compare(o2.getDate().getTime(), o1.getDate().getTime());
		}		
	}
	
}
