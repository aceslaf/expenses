
public class DailyExpenseCostComparator extends AbstractDailyExpenseComparator{

	protected DailyExpenseCostComparator(boolean isAscending) {
		super(isAscending);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(DailyExpense o1, DailyExpense o2) {
		if(this.isAscending())
		{
			return Float.compare(o1.getCost(), o2.getCost());
		}else
		{
			return Float.compare(o2.getCost(), o1.getCost());
		}
	}

}
