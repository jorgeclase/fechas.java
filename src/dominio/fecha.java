package fechas.src.dominio;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import fechas.src.presentacion.Interfaz;

import java.time.Period;

public class fecha implements Interfaz {
    private LocalDateTime fechaActual;
    private LocalDateTime fechaActualEnBogota;
    private long anosTranscurridos;
    private LocalDateTime descubrimientoDeAmerica;
    private LocalDateTime neilArmstrongPisoLaLuna;
    private LocalDateTime fechaFinalDeLaCarrera;
    private DateTimeFormatter formatoDeFecha;

    public fecha() {
        fechaActual = LocalDateTime.now();
        fechaActualEnBogota = LocalDateTime.now(ZoneId.of("America/Bogota"));
        descubrimientoDeAmerica = LocalDateTime.of(1492, 10, 12, 0, 0);
        neilArmstrongPisoLaLuna = LocalDateTime.of(1969, 7, 21, 3, 56);
        fechaFinalDeLaCarrera = LocalDateTime.of(2028, 6, 21, 12, 0, 0);
        formatoDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }

    @Override
    public void mostrarFechaActual() {
        System.out.println("\n🌍 **Fecha actual**:");
        System.out.println("Hoy es: " + fechaActual.format(formatoDeFecha));
    }

    @Override
    public void mostrarFechaActualEnBogota() {
        System.out.println("\n🌎 **Fecha actual en Bogotá**:");
        System.out.println("En Bogotá ahora mismo es: " + fechaActualEnBogota.format(formatoDeFecha));
    }

    @Override
    public void mostrarAnosTranscurridosDesdeElDescubrimiento() {
        anosTranscurridos = ChronoUnit.YEARS.between(descubrimientoDeAmerica, fechaActual);
        System.out.println("\n🗺️ **Años transcurridos desde el descubrimiento de América**:");
        System.out.println("¡Han pasado " + anosTranscurridos + " años desde que Colón llegó a América!");
    }

    @Override
    public void mostrarHoraActual() {
        System.out.println("\n⏰ **Hora actual**:");
        System.out.println("La hora en tu zona es: " + fechaActual.toLocalTime());
    }

    @Override
    public void mostrarHoraActualEnBogota() {
        System.out.println("\n⏱️ **Hora actual en Bogotá**:");
        System.out.println("La hora en Bogotá es: " + fechaActualEnBogota.toLocalTime());
    }

    @Override
    public void mostrarDiferenciaHorariaEntreMadridYBogota() {
        long diferenciaHoras = ChronoUnit.HOURS.between(fechaActual.atZone(ZoneId.of("Europe/Madrid")), fechaActualEnBogota.atZone(ZoneId.of("America/Bogota")));
        System.out.println("\n⏳ **Diferencia horaria entre Madrid y Bogotá**:");
        System.out.println("La diferencia horaria entre Madrid y Bogotá es de " + diferenciaHoras + " horas.");
    }

    @Override
    public void mostrarFechaEnQueNeilArmstrongPisoLaLuna() {
        System.out.println("\n🌕 **Neil Armstrong pisó la luna**:");
        System.out.println("¡Recuerda ese momento histórico! Neil Armstrong pisó la luna el: " + neilArmstrongPisoLaLuna.format(formatoDeFecha));
    }

    @Override
    public void mostrarFechaFinalDeLaCarrera() {
        System.out.println("\n🎓 **Fecha final de la carrera**:");
        System.out.println("¡La fecha en que terminarás tu carrera será el: " + fechaFinalDeLaCarrera.format(formatoDeFecha));

        Period.between(fechaActual.toLocalDate(), fechaFinalDeLaCarrera.toLocalDate());

        long semanasRestantes = ChronoUnit.WEEKS
                .between(fechaActual.toLocalDate(), fechaFinalDeLaCarrera.toLocalDate());
        long diasRestantes = ChronoUnit.DAYS.between(fechaActual.toLocalDate(), fechaFinalDeLaCarrera.toLocalDate());
        long horasRestantes = ChronoUnit.HOURS.between(fechaActual.toLocalDate(), fechaFinalDeLaCarrera.toLocalDate());
        long minutosRestantes = ChronoUnit.MINUTES.between(fechaActual.toLocalDate(), fechaFinalDeLaCarrera.toLocalDate());
        long segundosRestantes = ChronoUnit.SECONDS.between(fechaActual.toLocalDate(), fechaFinalDeLaCarrera.toLocalDate());

        // Mostramos la diferencia en años, meses, semanas, días, horas, minutos y segundos
        System.out.println("\n🏁 **Diferencia en semanas, meses, dias, horas, minutos y segundos**:");       
        System.out.println("Semanas restantes: " + semanasRestantes);                
        System.out.println("Días restantes: " + diasRestantes);
        System.out.println("Horas restantes: " + horasRestantes);                
        System.out.println("Minutos restantes: " + minutosRestantes);
        System.out.println("Segundos restantes: " + segundosRestantes);        
    }

}