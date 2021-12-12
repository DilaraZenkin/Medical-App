<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card>
              <v-toolbar dark color="#1A5276">
                <v-toolbar-title>Patient Appointment</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                Appointment details go here...
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import PatientService from "../services/PatientService";
import DoctorService from "../services/DoctorService";
export default {
  name: "patient-appointment",
  data: () => ({
    enable: false,
    patient: {},
    doctor: {},
    updatedPatient: {},
  }),
  created() {
    PatientService.getLoggedInPatient(this.$store.state.user.id).then(
      (response) => {
        this.patient = response.data;
      }
    ),
      DoctorService.getSpecificDoctor(this.patient.doctorId).then(
        (response) => {
          this.doctor = response.data;
        }
      );
  },
  methods: {
    resetForm() {
      this.showForm = false;
      this.updatedPatient = {};
    },
    updatePatient() {},
  },
};
</script>

<style>
</style>