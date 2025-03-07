<template>

    <v-data-table
        :headers="headers"
        :items="deviceDashboard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeviceDashboardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "imei", value: "imei" },
                { text: "userId", value: "userId" },
                { text: "phoneNumber", value: "phoneNumber" },
                { text: "deviceStatus", value: "deviceStatus" },
                { text: "createdAt", value: "createdAt" },
                { text: "updatedAt", value: "updatedAt" },
            ],
            deviceDashboard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deviceDashboards'))

            temp.data._embedded.deviceDashboards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deviceDashboard = temp.data._embedded.deviceDashboards;
        },
        methods: {
        }
    }
</script>

