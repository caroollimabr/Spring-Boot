package com.collection.Collection;

public class App 
{
    public static void main( String[] args )
    {
    	String frase = null;
    	String novaFrase = null;
    	
    	try {
    	novaFrase = frase.toUpperCase();
    	    	
    	}catch (Exception e) {
			System.err.println(e.getMessage());
			novaFrase = "esta null, porem ja foi tratado";
						
		}finally {			
			System.out.println(novaFrase);
		}
    
    	System.out.println(novaFrase.toUpperCase());
    	
    }
}
