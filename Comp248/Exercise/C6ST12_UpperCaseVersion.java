
public class C6ST12_UpperCaseVersion {
	public static char[] upperCaseVersion(char[] a)
	{
		char i;
		for (i = 0; i < a.length; i++)
			a[i] = Character.toUpperCase(a[i]);
		return a;
	}
}
