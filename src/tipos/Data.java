package tipos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {
    public static void main(String[] args){
        // DATE
        Date novaData = new Date();
        System.out.println("Date() " + novaData + "\n");
        // Date(long Date) - milissegundos baseados no padrão epoch
        Long tempoEmMilissegundos = System.currentTimeMillis();
        System.out.println("Date(long Date) " + tempoEmMilissegundos);
        Date outraData = new Date(tempoEmMilissegundos);
        System.out.println("Date(long Date) " + outraData + "\n");
        // Before e After
        Date dataNoPassado = new Date(tempoEmMilissegundos);
        Date dataNoFuturo = new Date(tempoEmMilissegundos+10000);
        /* Comparando se a data no passado é posterior a data do futuro - FALSE */
        boolean ehDepois = dataNoPassado.after(dataNoFuturo);
        System.out.println("After " + ehDepois);
        /* Comparando se a data no futuro é anterior a data do passado - FALSE */
        boolean ehAntes = dataNoFuturo.before(dataNoPassado);
        System.out.println("Before " + ehAntes + "\n");
        // ComparteTo e Equals
        Date outraDataNoFuturo = new Date(tempoEmMilissegundos+10000);
        /* Equals */
        boolean ehIgual = dataNoFuturo.equals(outraDataNoFuturo);
        System.out.println("Equals " + ehIgual);
        /* CompareTo */
        int compareCaso1 = dataNoPassado.compareTo(dataNoFuturo);
        System.out.println("CompareTo " + compareCaso1);
        int compareCaso2 = dataNoFuturo.compareTo(dataNoPassado);
        System.out.println("CompareTo " + compareCaso2);
        int compareCaso3 = dataNoFuturo.compareTo(outraDataNoFuturo);
        System.out.println("CompareTo " + compareCaso3 + "\n");
        
        // toInstant
        /* Instant - imutavel e thread safe, modela um ponto da linha do tempo */
        Date dataInicio = new Date(tempoEmMilissegundos);
        System.out.println("teste Instant " + dataInicio);
        Instant instante = dataInicio.toInstant();
        System.out.println("Instant " + instante + "\n");

        // CALENDAR
        Calendar agora = Calendar.getInstance();
        System.out.println("Calendar " + agora);
        System.out.println("getTime " + agora.getTime());
        agora.add(Calendar.DATE, 2);
        System.out.println("2 dias depois " + agora.getTime());
        agora.add(Calendar.MONTH, 3);
        System.out.println("3 meses depois " + agora.getTime());
        agora.add(Calendar.YEAR, 27);
        System.out.println("27 anos depois " + agora.getTime() + "\n");
        /* Formatacao tipos.Data */
        System.out.printf("%tc \n", agora.getTime());
        System.out.printf("%tF \n", agora.getTime());
        System.out.printf("%tD \n", agora.getTime());
        System.out.printf("%tr \n", agora.getTime());
        System.out.printf("%tT \n\n", agora.getTime());

        // DATE FORMAT
        Date teste = new Date();
        String dateToStr = DateFormat.getInstance().format(teste);
        System.out.println("Date Format " + dateToStr);
        dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(teste);
        System.out.println("Date Format " + dateToStr);
        SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatacao.format(teste);
        System.out.println("Simple Date Format " + dataFormatada + "\n");
       
        // LOCAL DATE, LOCAL TIME e LOCAL DATE TIME - Java 8
        LocalDate hoje = LocalDate.now();
        LocalDate ontem = hoje.minusDays(1);
        System.out.println("Local Date " + hoje);
        System.out.println("Local Date " + ontem);
        LocalTime hora = LocalTime.now();
        LocalTime maisUmaHora = hora.plusHours(1);
        System.out.println("Local Time " + hora);
        System.out.println("Local Time " + maisUmaHora);
        LocalDateTime dataHorario = LocalDateTime.now();
        LocalDateTime futuraData = dataHorario.plusHours(1).plusDays(2).plusSeconds(3);
        System.out.println("Local Date Time " + dataHorario);
        System.out.println("Local Date Time " + futuraData);
    }
}