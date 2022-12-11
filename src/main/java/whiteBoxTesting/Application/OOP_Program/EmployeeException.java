package whiteBoxTesting.Application.OOP_Program;

public class EmployeeException extends RuntimeException// extends RuntimeException yapmak zorundayiz
{
    public EmployeeException(String message)
    {
        super(message);//javanin icindeki consolde exception yazirma islemini hazir aliyorum nerden parenttan
    }

}


//javada kendi exception turumzuu yaxabilyoruz
//noSuchElementException(selenium) resmi exception turudur
//nullPointException(java) resmi exception


//ben kafama gore exception olusturabilir miyim? - evet, java bu hizmeti bize verir

