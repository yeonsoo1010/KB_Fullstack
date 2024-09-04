<template>
    <ul class="navbar-nav ms-auto">
        
    <template v-if="islogin">
        <AccountMenuItem :username="username" />
        <LogoutMenuItem />
    </template>


    <template v-else>
        <MenuItem :menu="login" />
        <MenuItem :menu="join" />
    </template>
    </ul>
</template>