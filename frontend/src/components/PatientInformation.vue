<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card>
              <v-toolbar dark color="#1A5276">
                <v-toolbar-title>Patient Information</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form @submit.prevent="updatePatient">
                  <v-text-field
                    id="firstname"
                    :disabled="!enable"
                    prepend-icon="person"
                    label="First Name"
                    v-model="patient.firstName"
                    required
                    autofocus
                    outlined
                  ></v-text-field>
                  <v-text-field
                    id="lastname"
                    :disabled="!enable"
                    prepend-icon="person"
                    class="form-control"
                    label="Last Name"
                    v-model="patient.lastName"
                    required
                    outlined
                  ></v-text-field>
                  <v-menu
                    v-model="dateOfBirthMenu"
                    :close-on-content-click="false"
                    :nudge-right="40"
                    transition="scale-transition"
                    offset-y
                    max-width="290px"
                    min-width="290px"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field
                        :disabled="!enable"
                        label="Date Of Birth"
                        prepend-icon="event"
                        readonly
                        v-on="on"
                        id="dateOfBirth"
                        class="patientInfo"
                        v-model="patient.dateOfBirth"
                        outlined
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      locale="en-in"
                      :disabled="!enable"
                      v-model="patient.dateOfBirth"
                      no-title
                      @input="dateOfBirthMenu = false"
                      :max="today"
                    ></v-date-picker>
                  </v-menu>
                  <v-text-field
                    id="address"
                    :disabled="!enable"
                    prepend-icon="location_on"
                    class="patientInfo"
                    label="Address"
                    v-model="patient.patientAddress"
                    required
                    outlined
                  ></v-text-field>
                  <v-text-field
                    id="doctor"
                    :disabled="!enable"
                    prepend-icon="person"
                    class="form-control"
                    label="Doctor"
                    v-model="patient.doctorLastName"
                    required
                    outlined
                  ></v-text-field>
                  <v-card-actions>
                    <v-checkbox
                      v-model="enable"
                      label="Need an Update?"
                    ></v-checkbox>
                    <v-spacer></v-spacer>
                    <v-btn color="#1A5276" dark type="submit">Save</v-btn>
                  </v-card-actions>
                </v-form>
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
export default {
  name: "patient-information",
  data: () => ({
    enable: false,
    patient: {},
    updatedPatient: {},
  }),
  created() {
    PatientService.getLoggedInPatient(this.$store.state.user.id).then(
      (response) => {
        this.patient = response.data;
      }
    );
  },
  methods: {
    resetForm() {
      this.showForm = false;
      this.updatedPatient = {};
    },
    updatePatient() {
        PatientService.updatePatientInformation(this.updatedPatient);
    },
  },
};
</script>

<style>
</style>