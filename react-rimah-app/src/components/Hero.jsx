import {
  Stack,
  Flex,
  Button,
  Text,
  VStack,
  useBreakpointValue,
  Box,
  Container,
} from '@chakra-ui/react';

export default function Hero() {
  return (
    <Flex
        w={'full'}
        h={'100vh'}
        backgroundImage={"https://images.unsplash.com/photo-1532676025685-271dabd9aa89?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80"}
        backgroundSize={'cover'}
        backgroundPosition={'center center'}>
    <VStack align="center">
      <Box mt={150}>
        <Text fontSize="5xl" as='mark'>Go Vegan </Text>
        <Container mt={30} mb={50}>
          There are many benefits to a joint design and development system. Not
          only does it bring benefits to the design team, but it also brings
          benefits to engineering teams. It makes sure that our experiences have
          a consistent look and feel, not just in our design specs, but in
          production
        </Container>
      </Box>
    </VStack>
    </Flex>
  );
}
