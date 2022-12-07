

public class ConcreteFactory implements Abstractfactory{
	
	@Override
	public Pack getPackageUniv(TypePackage typePackage) {
		
		if (typePackage == TypePackage.Standard)
	     {
			
			return new Standard();
			
			
	     }
	     else if (typePackage == TypePackage.Premium)
	     {
	    	 return new Premium();
			 
	    	 
	     }
		return null;
}
}



