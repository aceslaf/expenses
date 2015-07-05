
public class DailyExpensesItemsCountComparator extends AbstractDailyExpenseComparator {

	protected DailyExpensesItemsCountComparator(boolean isAscending) {
		super(isAscending);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(DailyExpense arg0, DailyExpense arg1) {
		int leftObjItemCount=arg0.getDescription().split("\n").length;
		int rightObjItemCount=arg1.getDescription().split("\n").length;
		if(this.isAscending())
		{
			return Integer.compare(leftObjItemCount, rightObjItemCount);
		}else
		{
			return Integer.compare( rightObjItemCount,leftObjItemCount);

		}
		
	}

}
