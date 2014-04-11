package biblioj

class ReservationService {

    boolean transactional = true

    def getNewReservation() {
        Reservation reservation = new Reservation(codeReservation: "test", dateReservation: new Date()+2)
        reservation.save()

        return reservation
    }
}
