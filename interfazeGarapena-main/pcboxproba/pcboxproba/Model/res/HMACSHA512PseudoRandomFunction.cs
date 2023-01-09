using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace pcboxproba.Model.res
{
    class HMACSHA512PseudoRandomFunction : IPseudoRandomFunction
    {
        private HMAC hmac;
        private bool disposed;

        public HMACSHA512PseudoRandomFunction(byte[] input)
        {
            hmac = new HMACSHA512(input);
        }

        public int HashSize
        {
            // Might as well return a constant 64
            get { return hmac.HashSize / 8; }
        }

        public byte[] Transform(byte[] input)
        {
            return hmac.ComputeHash(input);
        }

        public void Dispose()
        {
            if (!disposed)
            {
                hmac.Dispose();
                hmac = null;
                disposed = true;
            }
        }
    }
}
