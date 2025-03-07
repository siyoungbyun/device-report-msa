<template>

    <v-card outlined>
        <v-card-title>
            ReportDashboard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DeviceId" v-model="item.deviceId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ReviewerId" v-model="item.reviewerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="CreatedAt" v-model="item.createdAt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="UpdatedAt" v-model="item.updatedAt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ReportStatus" v-model="item.reportStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReportDashboardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/reportDashboards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

