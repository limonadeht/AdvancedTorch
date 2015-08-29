package lychemon.advtorch.util;

public enum Energy
{
	AdvancedTorch("AdvancedTorch", "AT");

	private String name;
	private String symbol;

	Energy(String name, String symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}

	public String getName()
	{
		return name;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public String getPlural()
	{
		return name + "s";
	}
}
