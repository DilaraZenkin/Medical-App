<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <div class="text-center">
              <v-btn rounded color="#1A5276" dark :to="{ name: 'doctor-list' }">
                Create New Appointment
              </v-btn>
            </div>
            <v-spacer></v-spacer>
            <br />
            <v-card
              v-bind:key="appointment.id"
              v-for="appointment in appointments"
            >
              <v-toolbar dark color="#1A5276">
                <v-toolbar-title>Patient Appointment</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <div>Upcoming Appointments</div>
                <p class="text-h4 text--primary">
                  {{ appointment.dayOfAppointment }}
                </p>
                <p>{{ appointment.appointmentDate }}</p>
                <div class="text--primary">
                  From: {{ appointment.startTime }}
                </div>
                <div class="text--primary">To: {{ appointment.endTime }}</div>
                <v-btn rounded color="#1A5276" dark @click="cancel(appointment.appointmentId)">
                  Cancel Appointment
                </v-btn>
              </v-card-text>
            </v-card>
            <v-dialog v-model="dialog" width="500">
              <v-card>
                <v-card-title class="text-h5 green lighten-2">
                  Success
                </v-card-title>
                <v-card-text> Appintment cancelled. </v-card-text>
                <v-divider></v-divider>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="green" text @click="refetchAppointments()"> Ok </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import appointmentService from "../services/AppointmentService";
export default {
  name: "patient-appointment",
  data: () => ({
    enable: false,
    patient: {},
    doctor: {},
    dialog: false,
    updatedPatient: {},
    appointments: [],
  }),
  created() {
    appointmentService
      .getPatientsFullAppointmentList(this.$store.state.user.id)
      .then((response) => {
        this.appointments = response.data;
      });
  },
  methods: {
    resetForm() {
      this.showForm = false;
      this.updatedPatient = {};
    },
    cancel(appointmentId) {
      appointmentService.cancelAppointment(appointmentId).then((response) => {
        if(response){
          this.dialog = true;
        }
      });
    },
    refetchAppointments() {
      this.dialog = false;
      appointmentService
      .getPatientsFullAppointmentList(this.$store.state.user.id)
      .then((response) => {
        this.appointments = response.data;
      });
    }
  },
};
</script>

<style>
</style>