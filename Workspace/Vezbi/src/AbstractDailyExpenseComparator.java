import java.util.Comparator;


public abstract class AbstractDailyExpenseComparator implements Comparator<DailyExpense>{
private boolean isAscending;
protected AbstractDailyExpenseComparator(boolean isAscending)
{
	this.isAscending=isAscending;
}
public boolean isAscending() {
	return isAscending;
}
}
