<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card
             v-bind:key="appointment.id"
            v-for="appointment in appointments">
              <v-toolbar dark color="#1A5276">
                <v-toolbar-title>Doctor Appointment</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <div>Upcoming Appointments</div>
                <p class="text-h4 text--primary">{{appointment.dayOfAppointment}}</p>
                <p>{{appointment.appointmentDate}}</p>
                <div class="text--primary">
                From: {{appointment.startTime}}
                </div>
                <div class="text--primary">
                 To: {{appointment.endTime}}
                  
                </div>
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
    <div id="app">
  <v-app id="inspire">
    <div class="text-center">
      <v-btn
        rounded
        color="primary"
        dark
        :to="{name: 'doctor-list'}"
      >
        Change Appointment
      </v-btn>
    </div>
  </v-app>
</div>
  </v-app>
</template>

<script>
import appointmentService from "../services/AppointmentService";
export default {
  name: "doctor-appointment",
  data: () => ({
    enable: false,
    patient: {},
    doctor: {},
    updatedAppointment: {},
    appointments: []
  }),
  created() {
      appointmentService.getDoctorFullAppointmentList(this.$store.state.user.id).then(
        (response) => {
          this.appointments = response.data;
        }
      );
  },
  methods: {
    resetForm() {
      this.showForm = false;
    },
    updateAppointment() {},
  },
};
</script>

<style>
</style>