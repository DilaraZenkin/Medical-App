<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card
              :loading="loading"
              v-bind:key="doctor.id"
              v-for="doctor in doctors"
            >
              <template slot="progress">
                <v-progress-linear
                  color="deep-purple"
                  height="10"
                  indeterminate
                ></v-progress-linear>
              </template>
              <v-toolbar dark color="#1A5276">
                <v-card-title
                  >{{ doctor.firstName }} {{ doctor.lastName }}</v-card-title
                >
              </v-toolbar>
              <v-card-text>
                <v-row align="center" class="mx-0">
                  <v-rating
                    :value="4.5"
                    color="amber"
                    dense
                    half-increments
                    readonly
                    size="14"
                  ></v-rating>
                  <div class="grey--text ms-4">4.5 (413)</div>
                </v-row>
                <div class="my-4 text-subtitle-1">{{ doctor.dateOfBirth }}</div>
                <div>{{ doctor.officeAddress }}</div>
              </v-card-text>
              <v-divider class="mx-4"></v-divider>
              <v-card-title>Availability</v-card-title>
              <v-card-text>
                <v-chip-group
                  v-model="doctor.time"
                  active-class="deep-purple accent-4 white--text"
                  column
                  default="12:00"
                  required
                >
                  <v-chip>5:00PM</v-chip>
                  <v-chip>6:00PM</v-chip>
                  <v-chip>7:00PM</v-chip>
                  <v-chip>8:00PM</v-chip>
                </v-chip-group>
              </v-card-text>
              <v-card-actions>
                <v-btn color="#1A5276" dark @click="reserve(doctor)">
                  Book Appointment
                </v-btn>
              </v-card-actions>
            </v-card>
            <v-dialog
      v-model="dialog"
      width="500"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="red lighten-2"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Click Me
        </v-btn>
      </template>

      <v-card>
        <v-card-title class="text-h5 grey lighten-2">
          Success
        </v-card-title>
        <v-card-text>
          Your appointment is confirmed.
        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="primary"
            text
            @click="dialog = false"
          >
            Ok
          </v-btn>
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
import doctorService from "../services/DoctorService";
import appointmentService from "../services/AppointmentService";
export default {
  name: "doctor-list",
  data: () => ({
    loading: false,
    doctors: [],
    dialog: false,
    text: `Appointment booked successfully`,
  }),
  created() {
    doctorService.getDoctors().then((response) => {
      this.doctors = response.data;
      this.isLoading = false;
    });
  },
  methods: {
    reserve(doctor) {
      console.log(doctor);
      if (doctor.time === 0) {
        doctor.startTime = "05:00:00";
        doctor.endTime = "06:00:00";
      }else if (doctor.time == 1){
        doctor.startTime = "06:00:00";
        doctor.endTime = "07:00:00";
      }else if (doctor.time == 2){
        doctor.startTime = "07:00:00";
        doctor.endTime = "08:00:00";
      } else if(doctor.time == 3){
        doctor.startTime = "07:00:00";
        doctor.endTime = "08:00:00";
      }
      doctor.dayOfAppointment = "2021-10-10";
      doctor.patientId = this.$store.state.user.id;
      this.loading = true;
      appointmentService.createAppointment(doctor).then((response) => {
        console.log(response);
        this.dialog = true;
        this.loading = false;
      });

      // call appointment service
      // endpoint: POST: http://localhost:8080/appointments/add
      // this.loading = true;
      // setTimeout(() => (this.loading = false), 2000);
    },
  },
};
</script>