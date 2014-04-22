package biblioj

class ReservationService {

    boolean transactional = true

    def getNewReservation() {
        Reservation reservation = new Reservation(codeReservation: "res", dateReservation: new Date().plus(1))
        reservation.codeReservation = "res-" + Reservation.count
        reservation.save()

        return reservation
    }
}
