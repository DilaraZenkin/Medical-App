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
                <div>Address Details</div>
              </v-card-text>
              <v-divider class="mx-4"></v-divider>
              <v-card-title>Availability</v-card-title>
              <v-card-text>
                <v-chip-group
                  v-model="selection"
                  active-class="deep-purple accent-4 white--text"
                  column
                >
                  <v-chip>5:30PM</v-chip>
                  <v-chip>7:30PM</v-chip>
                  <v-chip>8:00PM</v-chip>
                  <v-chip>9:00PM</v-chip>
                </v-chip-group>
              </v-card-text>
              <v-card-actions>
                <v-btn color="#1A5276" dark @click="reserve">
                  Book Appointment
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>
<script>
import doctorService from "../services/DoctorService";
export default {
  name: "doctor-list",
  data: () => ({
    loading: false,
    selection: 1,
    doctors: [],
  }),
  created() {
    doctorService.getDoctors().then((response) => {
      this.doctors = response.data;
      this.isLoading = false;
    });
  },
  methods: {
    reserve() {
      this.loading = true;
      setTimeout(() => (this.loading = false), 2000);
    },
  },
};
</script>