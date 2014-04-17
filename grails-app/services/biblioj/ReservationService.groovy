package biblioj

class ReservationService {

    boolean transactional = true

    def getNewReservation() {
        Reservation reservation = new Reservation(codeReservation: "test", dateReservation: new Date().plus(1))
        reservation.save()

        return reservation
    }
}
