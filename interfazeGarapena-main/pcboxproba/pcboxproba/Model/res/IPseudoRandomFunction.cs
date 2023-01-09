using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace pcboxproba.Model.res
{
    interface IPseudoRandomFunction : IDisposable
    {
        int HashSize { get; }
        byte[] Transform(byte[] input);
    }
}
