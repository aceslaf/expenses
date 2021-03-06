import java.util.Comparator;


public class DailyExpenseComparatorFactory {

	public enum ComparatorType
	{
		DateAscending,
		DateDescending,
		CostAscending,
		CostDescending,
		ItemsCountAscendng,
		ItemsCountDescending
	}
	private static AbstractDailyExpenseComparator dateAscendingComparator=new DailyExpenseDateComparator(true);
	private static AbstractDailyExpenseComparator dateDescendingComparator=new DailyExpenseDateComparator(false);
	private static AbstractDailyExpenseComparator costAscendingComparator=new DailyExpenseCostComparator(true);
	private static AbstractDailyExpenseComparator costDescendingComparator=new DailyExpenseCostComparator(false);
	private static AbstractDailyExpenseComparator itemsCountAscendingComparator=new DailyExpensesItemsCountComparator(true);
	private static AbstractDailyExpenseComparator itemsCountDescendingComparator=new DailyExpensesItemsCountComparator(false);
	public static Comparator<DailyExpense> CreateComparator(ComparatorType comparatorType)
	{
		Comparator<DailyExpense> comparator=null;
		switch (comparatorType) {
		case DateAscending:
			comparator= dateAscendingComparator;
			break;
		case DateDescending:
			comparator= dateDescendingComparator;
			break;
		case CostAscending:
			comparator=costAscendingComparator;
			break;
		case CostDescending:
			comparator=costDescendingComparator;
		case ItemsCountAscendng:
			comparator=itemsCountAscendingComparator;
			break;
		case ItemsCountDescending:
			comparator=itemsCountDescendingComparator;
			break;
			
		default:
			throw new UnsupportedOperationException();			
		}
		return comparator;
	}
}
