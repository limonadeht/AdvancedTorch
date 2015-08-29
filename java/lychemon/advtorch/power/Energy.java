package lychemon.advtorch.power;

public enum Energy
{

	MultiEngineeing("MultiEngineeing", "MT");

	private String symbol;
	private String name;

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

	public String getPural()
	{
		return name + "s";
	}
}
