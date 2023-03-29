package tek.sdet.framework.utilities;

import net.datafaker.Faker;
public class DataGeneratorUtility {
    public static void main(String[]args) {
        System.out.println(data("firstName"));
        System.out.println(data("lastName"));
        System.out.println(data("email"));
        System.out.println(data("phoneNumber"));
        System.out.println(data("fullName"));
        System.out.println(data("address"));
        System.out.println(data("city"));
        System.out.println(data("state"));
        System.out.println(data("zipCode"));
        System.out.println(data("expt"));
    }
    public static String data(String input) {

		Faker faker = new Faker();

		String outPut = "";
		
		if (input.equals("firstName")) {
			outPut = faker.name().firstName();
		} else if (input.equals("lastName")) {
			outPut = faker.name().lastName();
		} else if (input.equals("email")) {
			outPut = faker.expression("#{letterify '?????@tekschool.us'}");
		} else if (input.equals("PhoneNumber")) {
			outPut = faker.phoneNumber().cellPhone();
		} else if (input.equals("fullName")) {
			outPut = faker.name().fullName();
		} else if (input.equals("StreetAddress")) {
			outPut = faker.address().streetAddress();
		} else if (input.equals("city")) {
			outPut = faker.address().city();
		} else if (input.equals("state")) {
			outPut = faker.address().state();
		} else if (input.equals("zipCode")) {
			outPut = faker.address().zipCode();
		}else if (input.equals("country")) {
			outPut = "United States";
		}else if(input.equals("apt")) {
			outPut = faker.address().secondaryAddress();
		}else if(input.equals("cardNumber")) {
			outPut = faker.number().digits(16);
		}else if(input.equals("nameOnCard")) {
			outPut = faker.name().fullName();
//		}else if(input.equals("expirationMonth")) {
//			 outPut =faker.number;
//		}else if(input.equals("expirationYear")) {
//			 outPut =faker.number().numberBetween(2023, 2042);
		}

		return outPut;
	}

}
